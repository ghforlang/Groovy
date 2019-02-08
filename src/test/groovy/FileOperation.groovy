package test.groovy

//文件读取
def file = new File("UseTest.groovy")

//1、读取文件的每一行：eachLine 的唯一参数是一个Closure
file.eachLine{
    String line -> println line //或者直接使用 println it
//    println it
}

//2、直接得到文件内容,文件内容一次性读出，返回类型为byte[]
println file.getBytes()

//3、使用InputStream.InputStream
def ism = file.newInputStream()
ism.close() //操作ism记得关掉

//4、使用闭包操作inputStream,这里cism不用close，groovy会自动替你关掉
file.withInputStream {cism -> println cism.bytes}

//写文件,这里以文件copy为例
def targetFile = new File("UserTestCopy.groovy")
targetFile.withOutputStream {
    ops ->
        file.withInputStream {
            ins -> ops << ins
        }
}
