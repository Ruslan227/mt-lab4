##### Формат входного файла:

Блок инициализации:

```
E(int val, int val2, String val3)
```
```
T(int val)
```
```
// non-terminal(arguments)
... 
```

Блок правил:

```
E {val = 66; val2 = T.val; val3 = E.val3;} -> E + T
```
```
E {val = E[0].val; val2 = E[1].val2; val3 = T.val.toString()} -> E E T
```
``` 
// non-terminal {constructor code} -> right part
...
```

- i-ая строка блока инициализации описывает **класс**.  
- Если нетерминал не встречается в блоке инициализации, подразумевается, что данный нетерминал не учавствует в передаче синтезируемых атрибутов, соответственно, в блоке правил не должно быть блока кода около данного нетерминала. 
- **может оказаться, что несколько одинаковых нетерминалов справа. Как тогда вызывать их в конструкторе? Завести индексирование одинаковых нетерминалов?**

##### Обработка ошибок
1. Нетерминал существует в блоке инициализации => должен быть блок кода в соответствующем правиле, и наоборот.
2. аргументы в блоках должны совпадать (их кол-во и названия)


### Rules block 

`T { val = E[0].a ; val2 = E[1].b ; } -> E + E`

```
public class T {
	public final int val;
	public final int val2;
	
	Map<Right_Part, Constructor> rightPartConstructor = 
	Map.of("E + E", Function { val = E[0].a ; val2 = E[1].b ; });
	// all rules with own constructor
	
	to tell you the truth:
	Map<Right_Part, Constructor> rightPartConstructor = 
		Map.of("E + E", Function (Map<String, List<Object>> m) => { 
			bad // val = m.get("E").get(0).a; Object doesn't have 'a'
			val = ((E) m.get("E").get(0)).a; // it need cast 
			val2 = ((E) m.get("E").get(1)).b;
		})
}
```
У конструкторов биекция с правилами. 

Сначала генерим классы (нетерминалы), потом уже парсер. 

В парсере будет 
```
Map<NonTerminal, Map<Right_Part, Constructor>> constructors = Map.of("T", T::rightPartConstructor) // ...
```

While reducing we will have two stacks: __Stack\<String>__ and __Stack\<Object>__. 


Example:  
`strs |E + E `  
`objs |e0 e1 `

Reduce will clean two stacks and than parse it. After parsing we will have `Map<String, List<Object>> m = { "E" : {e0, e1} }`

After parsing we will want to create new object, so reduce will invoke appopriate class constructor with parsed information:
`T t =  Parser.constructors.get("T").get("E + E").apply(m); //new T(m);` 

After that reduce will put into `Stack<String>` `"T"` and into `Stack<Object>` `t`.

----

###Steps:  
- 1 parse grammar  
- 2 генерим классы нетерминалов  
- 3 генерим классы правых частей
- 4 генерим класс Parser, инициализируем поля   `rightPartConstructor`, `nonTerminalConstructor` 
- 5 строим управляющую таблицу и засовываем ее в класс Parser



**T { val = E[0].a ; val2 = E[1].b ; } -> E + E**. 

```
class T {
	public int val;
	public E val2;
	public Z val3;

	public T(RightPartN rightPart) {
  		val = rightPartN.e0.a; // it doesn’t need cast 
  		val2 = rightPartN
  		val3 = rightPathN.e0.a + 1
 	}
 
 	public T(RightPartM rightPart) {
     ...
 	}
 	// перегрузка конструкторов
 	
 	при чтении первого блока в input.txt
 	генерим класс с полями.
 	
 	при чтении каждого правила, записываем
 	в конец файла класса новый конструктор
 	
 	после всего парсинга в каждый файл 
 	класса нетерминала доставляем фигурную
 	скобку, закрывающую класс

}
```

```
class Parser {
public Map<rightPart, RPn::new> rightPartConstructor
public Map<nonTerminalString, nonTerminalClass::new> nonTerminalConstructor
// RPn - class of appopriate rightPart
}
```

```
class RPn {
E e0, e1
// A a0

	public RPn(Map<NonTerminal, List<Object>> m) {
		this.e0 = (E) m.get("E").get(0);
		...
	}
}

need: 
String nonTerminal (in left part)
long long id 

String fields
//Map<nonTerminal, Amount> getFields

```

```
Reduce () {
	stack<String> s1
	stack<Object> s2
	// reduce knows how to get necessary 
	needable String rightPart = ...
	needable Map<NonTerminal, List<Object>> objs = ...
	
	s1.add(needableNonTerminalString)
	s2.add(Parser.
		  nonTerminalConstructor.
		  get(needableNonTerminalString)
		  .apply(Parser.rightPartConstructor
		  		.get(rightPart)
		  		.apply(objs)
		  		 )
		  )
}
```



```
StateRunner { // code to generate
State state

	StateRunner(controlTable) {
		state = new State(controlTable)
		// add Parser to State constructor arg
		// Reduce need Parser methods and collections
	}
	
	public Object run() {
		Command command = state.controlTable.getStartCommand();
		
		while !state.isParsingEnd() {
			state = command.doAction(state)
		}
		
		return state.getObjects.get(0);
	}

}
```

# Исправление ошибок:
### необходимо создать:

- Enum TerminalToken
- Lexer

```
class Lexer {
	String input
	int ind = 0
	TerminalToken currentToken
	String currentValue
	Map<String, TerminalToken> regexpToken

	constructor Lexer(s: String) {
		input = s
	}
	
	String getCurrentValue() {
		return currentValue
	}
	
	TerminalToken getCurrentToken() {
		return currentToken
	}
	
	void nextToken() {
		while (Character.isWhiteSpace(input[ind]) && ind < input.len) {
			ind++;
		}
		
		if (ind == input.len)
			throw new Exception("unexpected end of line");
			
		for (regexp, token in regexpToken) {
			if regexp.matcher.find(ind) && matcher.start() == ind {
				currentValue = matcher.group(0)
				currentToken = token
			}
		}
		
		
	}
}
```

Лексер будет создаваться и использоваться внутри парсера. Из `State` удалить `inputLine`. Из `ControlTable` вытащить метод `parse` в `Parser`







