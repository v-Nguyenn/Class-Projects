using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SplittingText
{
    class StringSplitting
    {
        static void Main(string[] args)
        {
            string userInput = string.Empty;
            Console.WriteLine("give me a string of text");
            userInput = Console.ReadLine();
            string[] tokens = userInput.Split(' ');
            foreach(string token in tokens)
                Console.WriteLine(token);
        }
    }
}
