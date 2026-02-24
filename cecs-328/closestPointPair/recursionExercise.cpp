// Author: Vincent Nguyen
// CECS 328
// Due 02/24/2026

#include <fstream> // Read files
#include <vector> // Vectors to dynamically store the points
#include <chrono> // Keep track of timing in C++
#include <iostream>
#include <string>
#include <iomanip> // input, output formatting.
#include <cmath>
#include <limits>
#include <algorithm>
using namespace std;

// Struct to represent a 2D point with x and y coordinates
struct Point 
{
   double x, y;
};

// Struct to store results for each test
struct Result {
   std::string filename;
   int num_points;
   double min_dist;
   double elapsed_sec;
};

double point_distance(const Point& a, const Point& b) 
{
    return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
}

// Read the points
vector<Point> read_points(const string& filename)
{
   vector<Point> points;
   ifstream file (filename);
   if(!file)
   {
      cerr << "Error: Could not open file " << filename << endl; // cerr is the standard error message in C++
   return points;
   }
   char ch;
   double x, y;
   file >> ch; // Skip the first '{'
   while (file >> ch)
   {
      if (ch == '{')
      {
         file >> x >> ch >> y >> ch; // ch reads ',' and then '}'
         points.push_back({x, y});
         file >> ch;
         if (ch == '}') break;
      }
   }
   cout << "[DEBUG] Points read: " << points.size() << endl;
   return points;
}

// Brute force function
double brute_force_closest(const vector<Point>& points)
{
   double min_dist = numeric_limits<double>::max();
   size_t n = points.size();
   size_t total = n * (n - 1) / 2;
   size_t count = 0;
   const int bar_length = 50;
   for (size_t i = 0; i < n; ++i)
   {
      for (size_t j = i + 1; j < n; ++j)
      {
         double d = point_distance(points[i], points[j]);
         if (d < min_dist) min_dist = d;
         ++count;
         if (total > 0 && count % (total / bar_length + 1) == 0) {
            int progress = (int)((count * bar_length) / total);
            cout << "\r[";
            for (int k = 0; k < progress; ++k) cout << "*";
            for (int k = progress; k < bar_length; ++k) cout << "-";
            int percent = (int)((count * 100) / total);
            cout << "] " << percent << "%" << flush;
         }
      }
   }
   // Ensure bar is complete at 100%
   cout << "\r[";
   for (int k = 0; k < bar_length; ++k) cout << "*";
   cout << "] 100%\n";
   return min_dist;
}

// Helper functions for divide-and-conquer
bool compare_x(const Point& a, const Point& b) { return a.x < b.x; }
bool compare_y(const Point& a, const Point& b) { return a.y < b.y; }

double brute_force_dc(const vector<Point>& pts, int left, int right) {
   double min_dist = numeric_limits<double>::max();
   for (int i = left; i <= right; ++i) {
      for (int j = i + 1; j <= right; ++j) {
         double d = point_distance(pts[i], pts[j]);
         if (d < min_dist) min_dist = d;
      }
   }
   return min_dist;
}

double closest_pair_dc(vector<Point>& Px, vector<Point>& Py, int left, int right) {
   if (right - left <= 3) return brute_force_dc(Px, left, right);
   int mid = left + (right - left) / 2;
   double mid_x = Px[mid].x;
   vector<Point> Py_left, Py_right;
   for (const auto& p : Py) {
      if (p.x <= mid_x) Py_left.push_back(p);
      else Py_right.push_back(p);
   }
   double d_left = closest_pair_dc(Px, Py_left, left, mid);
   double d_right = closest_pair_dc(Px, Py_right, mid + 1, right);
   double d = min(d_left, d_right);
   vector<Point> strip;
   for (const auto& p : Py) {
      if (abs(p.x - mid_x) < d) strip.push_back(p);
   }
   int sz = strip.size();
   for (int i = 0; i < sz; ++i) {
      for (int j = i + 1; j < sz && (strip[j].y - strip[i].y) < d; ++j) {
         double dist = point_distance(strip[i], strip[j]);
         if (dist < d) d = dist;
      }
   }
   return d;
}

double divide_and_conquer_closest(vector<Point> points) {
   int n = points.size();
   if (n < 2) return numeric_limits<double>::max();
   vector<Point> Px(points), Py(points);
   sort(Px.begin(), Px.end(), compare_x);
   sort(Py.begin(), Py.end(), compare_y);
   return closest_pair_dc(Px, Py, 0, n - 1);
}


int main()
{
   vector<string> files =
   {
      "pointData/1.txt",
      "pointData/2.txt",
      "pointData/3.txt",
      "pointData/4.txt",
      "pointData/5.txt",
      "pointData/6.txt",
      "pointData/7.txt",
      "pointData/8.txt",
      "pointData/9.txt",
      "pointData/10.txt"
   };

   vector<Result> results; // Store results for summary table
   while (true) 
   { 
      cout << "-----------------------------------------------------------------------" << endl;
      cout << "Select a file (1-" << files.size() << ") or 'q' to quit, or 11 to print the summary table:\n";
      cout << "-----------------------------------------------------------------------" << endl;
      for (size_t i = 0; i < files.size(); ++i)
         cout << i + 1 << ". " << files[i] << endl;
      cout << files.size() + 1 << ". Print summary table" << endl;
      cout << "> ";
      string input;
      cin >> input;
      if (input == "q" || input == "Q") {
         cout << "Exiting program.\n";
         break;
      }
      int choice = 0;
      try {
         choice = stoi(input);
      }  catch (...) {
         cerr << "Invalid input. Please enter a number or 'q'.\n";
         continue;
      }
      if (choice == (int)files.size() + 1) {
         // Print summary table
         if (!results.empty()) {
            cout << "\nSummary Table:" << endl;
            cout << left << setw(20) << "File" << setw(12) << "#Points" << setw(18) << "MinDist" << setw(12) << "Time(s)" << endl;
            cout << string(62, '-') << endl;
            for (const auto& r : results) {
               cout << left << setw(20) << r.filename << setw(12) << r.num_points << setw(18) << fixed << setprecision(6) << r.min_dist << setw(12) << setprecision(4) << r.elapsed_sec << endl << endl;
            }
         } else {
            cout << "No results to display yet." << endl;
         }
         continue;
      }
      if (choice < 1 || choice > (int)files.size()) {
         cerr << "Invalid choice.\n";
         continue;
      }
      string filename = files[choice - 1];
      vector<Point> points = read_points(filename);
      if (points.size() < 2) {
         cout << "Not enough points to compute a distance." << endl;
         continue;
      }
      // Algorithm selection menu
      cout << "Select algorithm to use:\n";
      cout << "  1. Brute-force\n";
      cout << "  2. Divide and conquer\n";
      cout << "Enter choice (1 or 2): ";
      int algo_choice;
      cin >> algo_choice;
      while (algo_choice != 1 && algo_choice != 2) {
         cout << "Invalid choice. Enter 1 or 2: ";
         cin >> algo_choice;
      }
      double min_dist = 0.0;
      auto start_time = chrono::high_resolution_clock::now();
      if (algo_choice == 1) {
         min_dist = brute_force_closest(points);
      } else {
         min_dist = divide_and_conquer_closest(points);
      }
      auto end_time = chrono::high_resolution_clock::now();
      chrono::duration<double> elapsed = end_time - start_time;
      cout << fixed << setprecision(3);
      cout << "Minimum distance: " << min_dist << endl;
      cout << "Elapsed time: " << elapsed.count() << " seconds" << endl << endl;
      // Store result for summary
      results.push_back(Result{filename, (int)points.size(), min_dist, elapsed.count()});
   }
   return 0;
}