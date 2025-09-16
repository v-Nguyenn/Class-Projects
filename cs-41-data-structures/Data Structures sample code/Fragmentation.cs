using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DynamicMemory
{
	class Program
	{
		unsafe
		static void Main(string[] args)
		{
			bool isTrue = true;
			bool isFalse = false;
			bool another = true;

			bool* pIsTrue = &isTrue;
			bool* pIsFalse = &isFalse;

			Console.WriteLine("Address of isTrue\t" + (uint)pIsTrue);
			Console.WriteLine("Address of isFalse\t" + (uint)pIsFalse);

			pIsFalse = &another;
			Console.WriteLine("Address of another\t" + (uint)pIsFalse);

		}
	}
}
