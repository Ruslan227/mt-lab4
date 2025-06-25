#!/bin/bash
echo "🚀 Starting full workflow..."
./run-grammar.sh && ./run-result-parser.sh
echo "✅ Full workflow completed successfully!"
