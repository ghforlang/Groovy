package test.groovy

// 一个是Java中的基本数据类型。
// 另外一个是Groovy中的容器类。
// 最后一个非常重要的是闭包。

//基本数据类型
// 作为动态语言，Groovy世界中的所有事物都是对象。所以，int，boolean这些Java中的基本数据类型，在Groovy代码中其实对应的是它们的包装数据类型
def int x = 3
println x.getClass().getCanonicalName()

//容器类
// Groovy中的容器类很简单，就三种：

// List：链表，其底层对应Java中的List接口，一般用ArrayList作为真正的实现类。
// Map：键-值表，其底层对应Java中的LinkedHashMap。
// Range：范围，它其实是List的一种拓展。

// list
//变量定义：List变量由[]定义，比如
def aList = [5,'string',true] //List由[]定义，其元素可以是任何对象
//变量存取：可以直接通过索引存取，而且不用担心索引越界。如果索引超过当前链表长度，List会自动往该索引添加元素
assert aList[1] == 'string'
println aList[4]

assert aList[5] == null//第6个元素为空
aList[100] = 100 //设置第101个元素的值为100
assert aList[100] == 100

//那么，aList到现在为止有多少个元素呢？
//println aList.size ===>结果是101
println aList.size()

//map
//变量定义：Map变量由[:]定义，比如
def aMap = ['key1':'value1','key2':true]
println aMap['key1']
// Map由[:]定义，注意其中的冒号。冒号左边是key，右边是Value。key必须是字符串，value可以是任何对象。另外，key可以用''或""包起来，也可以不用引号包起来。比如
def bMap = [key1:"value",key2:true]//其中的key1和key2默认被处理成字符串"key1"和"key2"

//Map中元素的存取更加方便，它支持多种方法：
println aMap.keyName    //这种表达方法好像key就是aMap的一个成员变量一样
println aMap['keyName'] //这种表达方法更传统一点
aMap.anotherkey = "i am map"  //为map添加新元素

//range
//Range是Groovy对List的一种拓展，变量定义和大体的使用方法如下：

def aRange = 1..5 //Range类型的变量 由begin值+两个点+end值表示,左边这个aRange包含1,2,3,4,5这5个值
//如果不想包含最后一个元素，则
def aRangeWithoutEnd = 1..<5  // 包含1,2,3,4这4个元素
println aRange.from
println aRange.to


//闭包
// 闭包，英文叫Closure，是Groovy中非常重要的一个数据类型或者说一种概念了
// 闭包，是一种数据类型，它代表了一段可执行的代码。其外形如下

def aClosure = {
        //闭包是一段代码，所以需要用花括号括起来..
    String param1, int param2 ->  //这个箭头很关键。箭头前面是参数定义，箭头后面是代码
        println "this is code" //这是代码，最后一句是返回值，
        //也可以使用return，和Groovy中普通函数一样
}

// 简而言之，Closure的定义格式是：
// def xxx = {paramters -> code}  //或者
// def xxx = {无参数，纯code}  这种case不需要->符号</code>

// 闭包定义好后，要调用它的方法就是：
// 闭包对象.call(参数)  或者更像函数指针调用的方法：
// 闭包对象(参数)

def bClosure={
    int param1,int param2->
        println "this is code"
}

//aClosure.call("this is string",100)
aClosure("this is string", 100)
//比如：
aClosure.call("this is string",100)
//或者
aClosure("this is string", 100)

// 在闭包中，还需要注意一点：
// 如果闭包没定义参数的话，则隐含有一个参数，这个参数名字叫it，和this的作用类似。it代表闭包的参数。
// 比如：
def greeting = { "Hello, $it!" }
println greeting.call()
assert greeting('Patrick') == 'Hello, Patrick!'
//等同于：
def greetings = { it -> "Hello, $it!"}
println greetings
assert greetings('Patrick') == 'Hello, Patrick!'
//但是，如果在闭包定义时，采用下面这种写法，则表示闭包没有参数！
def noParamClosure = { -> true }
//这个时候，我们就不能给noParamClosure传参数了！
noParamClosure.call() //报错喔！
//Closure使用中的注意点:省略圆括号
//闭包在Groovy中大量使用，很多类都定义了一些函数，这些函数最后一个参数都是一个闭包。
// 比如下面这个函数表示针对List的每一个元素都会调用closure做一些处理。这里的closure，就有点回调函数的感觉。但是，在使用这个each函数的时候，我们传递一个怎样的Closure进去呢？比如：
//public static <T> List<T>each(List<T> self, Closure closure)

def iamList = [1,2,3,4,5]  //定义一个List
iamList.each{ //调用它的each，这段代码的格式看不懂了吧？each是个函数，圆括号去哪了？
    println it
}
//上面代码有两个知识点：
//each函数调用的圆括号不见了！原来，Groovy中，当函数的最后一个参数是闭包的话，可以省略圆括号。比如
def testClosure(int a1,String b1, Closure closure){
    //dosomething
    closure() //调用闭包
}
//那么调用的时候，就可以免括号！
testClosure (4, "test", {
    println"i am in closure"
} )  //红色的括号可以不写..