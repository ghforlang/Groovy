package test.groovy

import groovy.util.slurpersupport.GPathResult

// XML的解析提供了和XPath类似的方法，名为GPath。
// 这是一个类，提供相应API。关于XPath，请脑补https://en.wikipedia.org/wiki/XPath。

// 1、创建xmlSlurper
def xParser = new XmlSlurper()
def targetFile = new File("test.xml")

GPathResult gPathResult = xParser.parse(targetFile)
//访问id=4的book元素,gpathResult代表根元素response。
// 通过e1.e2.e3这种格式就能访问到各级子元素.
def book4 = gPathResult.value.books.book[3]
//访问book4的author元素
def author = book4.author
println author
//访问圆度的属性及textValue
assert author.text() // == 'Manuel De Cervantes'
//获取属性
println author.@id //或者 author['@id']
//属性一般是字符串，可以通过toTnteger 转成整数
println author.@id.toInteger()
