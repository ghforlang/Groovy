package test.groovy

import groovy.transform.Field
import main.groovy.Test

def test = new Test("aaa","xxx")
test.print()

def function(a,b){
    c = a + b
    println c
}

function("xxx",123)
//在groovy中，系统自带会加载当前目录/子目录下的xxx.groovy文件。
// 所以，当执行groovy test.groovy的时候，test.groovy import的Test类能被自动搜索并加载到。

//1、xxx.groovy被转换成了一个test类（也可以这么理解，一个groovy脚本对应一个java类），它从script派生。
//2、每一个脚本都会生成一个static main函数。这样，当我们执行 groovy xxx.groovy的时候，其实就是用java去执行这个main函数
//3、脚本中的所有代码都会放到run函数中。比如，println 'Groovy world'，这句代码实际上是包含在run函数里的。
//4、如果脚本中定义了函数，则函数会被定义在test类中。

// 脚本中的变量和作用域
// 前面说了，xxx.groovy只要不是和Java那样的class，那么它就是一个脚本。
// 而且脚本的代码其实都会被放到run函数中去执行。那么，在Groovy的脚本中，很重要的一点就是脚本中定义的变量和它的作用域。举例

def x = 1 //注意，这个x有def（或者指明类型，比如 int x = 1）
def printx(){
    println x
}
//printx() //这里会报错，因为，x是run方法的局部变量，而printx是test类的方法，所以printx访问不到x，要想访问，需要把x去掉def或者类型,如下：

xx = 1 //注意，需要把x去掉def或者类型
// Groovy的文档说 xx = 1这种定义将使得xx变成test的成员变量，但从反编译情况看起来有一定出入，
// 实际上xx也没有被定义成test类的成员变量，而是在run的执行过程中，将xx作为一个属性添加到test实例对象中了。然后在printxx中，先获取这个属性。
def printxx(){
    println xx
}
printxx()
//虽然printxx可以访问xx变量了，但是假如有其他脚本却无法访问xx变量,因为它不是test的成员变量.
// 这种方法使得我们可以将代码分成模块来编写，比如将公共的功能放到test.groovy中，然后使用公共功能的代码放到useTest.groovy中。


// 这里要使用@Field 这个时候，test.groovy中的y就成了test类的成员函数了。这样，我们可以在script中定义那些需要输出给外部脚本或类使用的变量了！
@Field def y = 2
def printy(){
    println y
}
