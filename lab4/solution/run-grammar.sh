#!/bin/bash
echo "🚀 Starting grammar processing..."
mvn clean antlr4:antlr4 compile exec:java@run-grammar
echo "✅ Grammar processed! Parser generated in output/"