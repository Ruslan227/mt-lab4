# Parser Project Execution Guide

## 📁 Project Structure

```
.
├── run-all.sh           # Run full workflow
├── run-grammar.sh       # Generate ANTLR files + run grammar parser with parser generator
├── run-result-parser.sh # Run generated output parser
├── gen/                 # ANTLR-generated files
├── output/              # Generated parser files
└── src/                 # Source files
```


## 🚀 Simplified Execution

### 1. Run Full Workflow (Generate + Execute)
```bash
./run-all.sh
```
- Generates ANTLR parser files (gen/)
- Runs grammar parser (antrl.GrammarParser)
- Executes generated parser (output/Parser)

### 2. Generate Parser Only
```bash
./run-grammar.sh
```
- Generates ANTLR files to gen/
- Runs grammar parser
- Outputs files to output/

### 3. Run Generated Parser Only
```bash
./run-result-parser.sh
```
- Executes the parser in output/ directory
