// Author: Vincent Nguyen
// 0/1 Knapsack (each brick can be taken at most once)
#include <algorithm>
#include <cctype>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

struct Item {
	int value;
	int weight;
};

struct Result {
	int maxProfit;
	int usedWeight;
	vector<int> chosenIndices1Based;
};

// Parse an integer from s starting at i and advance i.
bool parseInt(const string &s, size_t &i, int &out) {
	while (i < s.size() && isspace(static_cast<unsigned char>(s[i]))) {
		++i;
	}

	if (i >= s.size()) {
		return false;
	}

	bool neg = false;
	if (s[i] == '-') {
		neg = true;
		++i;
	}

	if (i >= s.size() || !isdigit(static_cast<unsigned char>(s[i]))) {
		return false;
	}

	long long v = 0;
	while (i < s.size() && isdigit(static_cast<unsigned char>(s[i]))) {
		v = v * 10 + (s[i] - '0');
		++i;
	}

	out = neg ? static_cast<int>(-v) : static_cast<int>(v);
	return true;
}

// Parse flat format: {C, {int1, int2, int3, ...}}
// Pairs consecutive integers as (value, weight)
bool parseFlatInput(const string &line, int &capacity, vector<Item> &items) {
	size_t i = 0;
	items.clear();

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '{') {
		return false;
	}
	++i;

	if (!parseInt(line, i, capacity)) {
		return false;
	}

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != ',') {
		return false;
	}
	++i;

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '{') {
		return false;
	}
	++i;

	vector<int> nums;
	while (true) {
		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}

		if (i >= line.size()) {
			return false;
		}

		if (line[i] == '}') {
			++i;
			break;
		}

		int num = 0;
		if (!parseInt(line, i, num)) {
			return false;
		}
		nums.push_back(num);

		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}

		if (i < line.size() && line[i] == ',') {
			++i;
		}
	}

	// Pair consecutive numbers as (value, weight)
	for (size_t j = 0; j + 1 < nums.size(); j += 2) {
		int value = nums[j];
		int weight = nums[j + 1];
		if (weight < 0) {
			return false;
		}
		items.push_back({value, weight});
	}

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '}') {
		return false;
	}

	return true;
}

// Parse assignment format:
// {C, {{v1, w1, 1}, {v2, w2, 1}, ... }}
bool parseAssignmentInput(const string &line, int &capacity, vector<Item> &items) {
	size_t i = 0;
	items.clear();

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '{') {
		return false;
	}
	++i;

	if (!parseInt(line, i, capacity)) {
		return false;
	}

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != ',') {
		return false;
	}
	++i;

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '{') {
		return false;
	}
	++i;

	while (true) {
		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}

		if (i >= line.size()) {
			return false;
		}

		// End of outer list of items.
		if (line[i] == '}') {
			++i;
			break;
		}

		if (line[i] != '{') {
			return false;
		}
		++i;

		int v = 0;
		int w = 0;
		int one = 0;

		if (!parseInt(line, i, v)) {
			return false;
		}
		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}
		if (i >= line.size() || line[i] != ',') {
			return false;
		}
		++i;

		if (!parseInt(line, i, w)) {
			return false;
		}
		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}
		if (i >= line.size() || line[i] != ',') {
			return false;
		}
		++i;

		if (!parseInt(line, i, one)) {
			return false;
		}
		if (one != 1) {
			return false;
		}

		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}
		if (i >= line.size() || line[i] != '}') {
			return false;
		}
		++i;

		if (w < 0) {
			return false;
		}
		items.push_back({v, w});

		while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
			++i;
		}

		if (i < line.size() && line[i] == ',') {
			++i;
		}
	}

	while (i < line.size() && isspace(static_cast<unsigned char>(line[i]))) {
		++i;
	}
	if (i >= line.size() || line[i] != '}') {
		return false;
	}

	return true;
}

Result solveKnapsack01(int capacity, const vector<Item> &items) {
	int n = static_cast<int>(items.size());
	vector<vector<int>> dp(n + 1, vector<int>(capacity + 1, 0));

	for (int i = 1; i <= n; ++i) {
		int value = items[i - 1].value;
		int weight = items[i - 1].weight;

		for (int w = 0; w <= capacity; ++w) {
			dp[i][w] = dp[i - 1][w];
			if (weight <= w) {
				dp[i][w] = max(dp[i][w], dp[i - 1][w - weight] + value);
			}
		}
	}

	// Recover which items were chosen.
	vector<int> chosen;
	int w = capacity;
	for (int i = n; i >= 1; --i) {
		if (dp[i][w] != dp[i - 1][w]) {
			chosen.push_back(i); // 1-based index
			w -= items[i - 1].weight;
		}
	}
	reverse(chosen.begin(), chosen.end());

	int totalWeight = 0;
	for (int idx : chosen) {
		totalWeight += items[idx - 1].weight;
	}

	return {dp[n][capacity], totalWeight, chosen};
}

int main(int argc, char *argv[]) {
	int capacity = 0;
	vector<Item> items;
	string line;

	// If command-line argument provided, read from that file (1-10)
	if (argc > 1) {
		int fileNum = atoi(argv[1]);
		if (fileNum < 1 || fileNum > 10) {
			cout << "Please specify a file number between 1 and 10.\n";
			return 1;
		}

		string filename = "knapsackData\\" + to_string(fileNum) + ".txt";
		ifstream file(filename);
		if (!file) {
			cout << "Could not open file: " << filename << "\n";
			return 1;
		}
		getline(file, line);
		file.close();
		cout << "Loaded from file " << fileNum << ".txt\n\n";
	} else {
		// Interactive mode: ask user which file to load
		cout << "Select a knapsack data file (1-10) or press Enter for stdin:\n";
		string input;
		getline(cin, input);

		if (!input.empty()) {
			int fileNum = atoi(input.c_str());
			if (fileNum >= 1 && fileNum <= 10) {
				string filename = "knapsackData\\" + to_string(fileNum) + ".txt";
				ifstream file(filename);
				if (!file) {
					cout << "Could not open file: " << filename << "\n";
					return 1;
				}
				getline(file, line);
				file.close();
				cout << "Loaded from file " << fileNum << ".txt\n\n";
			} else {
				cout << "Invalid file number. Using stdin instead.\n\n";
				line = input;
			}
		} else {
			// Read from stdin for manual input
			cout << "Enter knapsack input in this format:\n";
			cout << "{C, {{v1, w1, 1}, {v2, w2, 1}, ...}}\n\n";
			getline(cin, line);
		}
	}

	if (!parseAssignmentInput(line, capacity, items)) {
		if (!parseFlatInput(line, capacity, items)) {
			// Fallback demo using the screenshot example if parsing fails or user presses Enter.
			capacity = 68;
			items = {
				{16, 19}, {5, 6}, {6, 12}, {19, 19}, {14, 18},
				{17, 10}, {20, 19}, {16, 11}, {12, 5}, {19, 16}
			};
			cout << "Input could not be parsed. Running built-in example instead.\n\n";
		}
	}

	if (capacity < 0) {
		cout << "Capacity must be non-negative.\n";
		return 1;
	}

	Result ans = solveKnapsack01(capacity, items);

	cout << "Capacity: " << capacity << "\n";
	cout << "Items: " << items.size() << "\n";
	cout << "Max profit: " << ans.maxProfit << "\n";
	cout << "Used weight: " << ans.usedWeight << "\n";
	cout << "Chosen item indices (1-based): ";
	for (size_t i = 0; i < ans.chosenIndices1Based.size(); ++i) {
		if (i) {
			cout << ", ";
		}
		cout << ans.chosenIndices1Based[i];
	}
	cout << "\n";

	return 0;
}
