package test.groovy
//
println "test groovy"

// Groovy注释标记和Java一样，支持//或者/**/
// Groovy语句可以不用分号结尾。Groovy为了尽量减少代码的输入，确实煞费苦心
// Groovy中支持动态类型，即定义变量的时候可以不指定其类型。Groovy中，变量定义可以使用关键字def。注意，虽然def不是必须的，但是为了代码清晰，建议还是使用def关键字
def variable1 = 1   //可以不使用分号结尾
def varable2 = "I ama person"
def  int x = 1  //变量定义时，也可以直接指定类型


// 函数定义时，参数的类型也可以不指定。比如
String testFunction(arg1,arg2){//无需指定参数类型
    "sljgosjog"
}


// 除了变量定义可以不指定类型外，Groovy中函数的返回值也可以是无类型的。比如：
//无类型的函数定义，必须使用def关键字
def  nonReturnTypeFunc(){
    last_line   //最后一行代码的执行结果就是本函数的返回值
}
//如果指定了函数返回类型，则可不必加def关键字来定义函数
String getString() {
    return "I am a string"
}

// 函数返回值：Groovy的函数里，可以不使用returnxxx来设置xxx为函数返回值。如果不使用return语句的话，则函数里最后一句代码的执行结果被设置成返回值。比如
//下面这个函数的返回值是字符串"getSomething return value"
/**
 注意，如果函数定义时候指明了返回值类型的话，函数中则必须返回正确的数据类型，否则运行时报错。如果使用了动态类型的话，你就可以返回任何类型了。
 */
def getSomething() {
    "getSomething return value" //如果这是最后一行代码，则返回类型为String
    1000//如果这是最后一行代码，则返回类型为Integer
}

// 对字符串的支持
// Groovy对字符串支持相当强大，充分吸收了一些脚本语言的优点：
// 单引号''中的内容严格对应Java中的String，不对$符号进行转义
  defsingleQuote='I am $ dolloar'  //输出就是I am $ dolloar

// 双引号""的内容则和脚本语言的处理有点像，如果字符中有$号的话，则它会$表达式先求值。
 defdoubleQuoteWithoutDollar = "I am one dollar" //输出 I am one dollar
 def xx = 1
 defdoubleQuoteWithDollar = "I am $xx dolloar" //输出I am 1 dolloar

// 三个引号'''xxx'''中的字符串支持随意换行 比如
defmultieLines = ''' begin
     line  1
     line  2
     end '''
//最后，除了每行代码不用加分号外，Groovy中函数调用的时候还可以不加括号。比如：
//println("test") ---> println"test"
//注意，虽然写代码的时候，对于函数调用可以不带括号，但是Groovy经常把属性和函数调用混淆。比如
def getHello(){
    "hello"
}

//所以，调用函数要不要带括号，我个人意见是如果这个函数是Groovy API或者Gradle API中比较常用的，比如println，就可以不带括号。
// 否则还是带括号。Groovy自己也没有太好的办法解决这个问题，只能兵来将挡水来土掩了。
