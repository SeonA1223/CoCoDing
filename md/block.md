# Code Generator

블록이 실제 프로그래밍 언어로 된 코드와 연결될 수 있게 하기 위해서는 code geneartor 라는 특수한 코드를 같이 붙여 주어야 한다.

보통 code generator는 block definition 부분과 별도의 .js파일로 분리하여 작성하게 된다.

**code generator 정의 구문은 Javascript 스타일로만 정의가 가능**

![https://vleudive.github.io/img/short_math_ex.png](https://vleudive.github.io/img/short_math_ex.png)

Python 코드 연결

→ 이 블록과 연결해서 생성하려는 코드는 a+=b, a*=b, a/=b, a-=b 중 한 가지

```jsx
Blockly.Python['short_math']=function(block)
{
    var num_1=Blockly.Python.valueToCode(block,'a',Blockly.Python.ORDER_ATOMIC);
    var dropdown_select = block.getFieldValue('select');
    var num_2=Blockly.Python.valueToCode(block,'b',Blockly.Python.ORDER_ATOMIC);
    var code=num_1+dropdown_select+"= "+num_2+"\\n";
    return code;
}
```

valueToCode() 함수는 세 번째 파라미터로 연산자 우선순위를 받는다.

## 연산자 우선순위

Blockly/generators/(언어명).js 파일 안에 각 언어별 연산자 우선순위가 지정되어 있다.

미리 지정되어 있는 값이기 때문에 사용할 때는 그 값을 고민할 필요 없이, 미리 지정되어 있는 해당 연산자의 이름만 호출해서 사용 가능

- ORDER_ATOMIC : 숫자나 String 등 하나의 독립적 값을 의미합니다.
- ORDER_NONE : 정의되어 있는 어떤 연산자에도 해당되지 않는 것을 리턴하는 경우나 리턴값이 없는 경우 등에 사용합니다.



# 블록 정의

정의 해 볼 블록

1. Top+Bottom connection
2. 2개의 value input
3. dropdown field ⇒ 연산의 종류 선택

```jsx정의 해 볼 블록
Blockly.Blocks['short_math'] = {
	init: function() {
		this.appendValueInput("a")
				.setCheck("Number");
		this.appendDummyInput()
				.appendField(new Blockly.FieldDropdown([
						["+", "+"], ["*", "*"], ["-", "-"], ["/", "/"]
					], "select")
				.appendField("=");
		this.appendValueInput("b")
				.setCheck("Number");
		this.setInputsInline(true);
		this.setPreviousStatement(true);
		this.setColour(260);
this.setTooltips("Short version of a arithmetic calculations");
this.setHelpUrl("");
	}
};

/*mutator나 extension 고급 기능을 추가하게 되면 
*init 외에도 다양한 메소드를 추가하게 되기 때문에, 
*복잡한 구조의 블록의 경우 init을 생략하지 않는 위의 방법이 더 바람직합니다
*/

/*
*“select” 는 이 dropdown field 자체의 이름을 지정한 것입니다. 
*후에 code generation 등을 할 때 지정자로서 요긴히 쓰입니다.
*/
```

