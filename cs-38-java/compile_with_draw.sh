#!/usr/bin/env bash
# ==============================================================================
# compile_with_draw.sh
# ==============================================================================
# Compiles ALL .java files in the project with the draw.jar library included.
# This is useful for bulk compilation when multiple files have dependencies.
#
# Usage:
#   ./compile_with_draw.sh
#
# Note: You can also compile individual files using VS Code (Cmd+Shift+B)
# ==============================================================================
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
JAR="$ROOT/Libs/draw.jar"

if [ ! -f "$JAR" ]; then
  echo "Error: $JAR not found. Make sure Libs/draw.jar exists." >&2
  exit 1
fi

echo "Finding .java files..."
find "$ROOT" -name "*.java" > "$ROOT/sources.txt"
echo "Compiling (this may take a bit)..."
javac -cp ".:$JAR" @"$ROOT/sources.txt"
echo "Compilation finished."
