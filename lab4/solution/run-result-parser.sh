#!/bin/bash
echo "🚀 Starting result parser..."
mvn compile exec:java@run-output
echo "✅ Parser executed!"