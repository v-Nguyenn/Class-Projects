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
using namespace std;

// Struct to represent a 2D point with x and y coordinates
struct Point 
{
   double x, y;
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

   while (true) 
   { 
      cout << "---------------------------------------" << endl;
      cout << "Select a file (1-" << files.size() << ") or 'q' to quit:\n";
         for (size_t i = 0; i < files.size(); ++i)
            cout << i + 1 << ". " << files[i] << endl;
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
         // (Removed printing of points to avoid excessive output for large sample sizes)
         auto start_time = chrono::high_resolution_clock::now();
         double min_dist = brute_force_closest(points);
         auto end_time = chrono::high_resolution_clock::now();
         chrono::duration<double> elapsed = end_time - start_time;
         cout << fixed << setprecision(3);
         cout << "Minimum distance: " << min_dist << endl;
         cout << "Elapsed time: " << elapsed.count() << " seconds" << endl << endl;
   }
   return 0;
}