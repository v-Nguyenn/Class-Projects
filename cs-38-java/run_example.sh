#!/usr/bin/env bash
# ==============================================================================
# run_example.sh
# ==============================================================================
# Runs a compiled Java program with the draw.jar library on the classpath.
# Automatically handles both full paths (Ch03/CW3VincentNguyen) and simple
# class names (CW3VincentNguyen).
#
# Usage:
#   ./run_example.sh <ClassPathOrClass>
#
# Examples:
#   ./run_example.sh Ch01/HW_Fundamentals_VincentNguyen
#   ./run_example.sh HW_Fundamentals_VincentNguyen
#
# Note: You can also run files using VS Code's play button (▶️)
# ==============================================================================
set -euo pipefail
if [ "$#" -lt 1 ]; then
  echo "Usage: $0 <ClassPathOrClass>" >&2
  echo "Example: $0 Ch03/CW3VincentNguyen  or  $0 CW3VincentNguyen" >&2
  exit 1
fi

ROOT="$(cd "$(dirname "$0")" && pwd)"
JAR="$ROOT/Libs/draw.jar"

if [ ! -f "$JAR" ]; then
  echo "Error: $JAR not found." >&2
  exit 1
fi

ARG="$1"
CLASSPATH=".:$JAR"

if [[ "$ARG" == */* ]]; then
  DIR=$(dirname "$ARG")
  CLASS=$(basename "$ARG")
  CLASSPATH="$CLASSPATH:$ROOT/$DIR"
else
  CLASS="$ARG"
fi

cd "$ROOT"
echo "Running class $CLASS with classpath: $CLASSPATH"
java -cp "$CLASSPATH" "$CLASS"
