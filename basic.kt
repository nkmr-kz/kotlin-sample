package my.demo
import kotlin.text.*

fun main(args:Array<String>){
    println(args . contentToString())
    println("hello world.")
    println(sum(1,2))
    printSum(1,3)

    val notChange = 1
//    notChange = 2  // error
    val init:Int
    init = 2
//    init = 4  // error
    var change = 1
    change = 3 // ok

    val rectangle = Rectangle(30.0,20.0)
    println(rectangle.primeter)

    // テンプレート構文
    val a = "a"
    println("aは$a")
    println("aは${a}")

    println(maxOf(2,3))

    // 式としてもifが使用可能
    // 3項演算子
    println(if( 3 > 2 ) 3 else 2)

    val iList = mutableListOf<Int>(1,2)
    println(iList)
    iList.add(3)
    println(iList)
    val items = listOf<String>("apple","banana","orange")
    for (item in items){
        println(item)

        // switch, case
        when(item){
            "apple" -> println("a")
            "banana" -> println("b")
            else -> println("?")
        }
    }
    val x = 10
    val y = 9
    if( x in 1..y+1){
        println("ok")
    }

    for ( x in 1..5 ){
        println(x)
    }

    when{
        "orange" in items -> println("orange")
        "apple" in items -> println("apple")
    }

    //　配列のループ時、itの中に各配列の値が入る
    items.
        filter { it.startsWith("a") }.
        forEach{ println(it)}

    items.
        filter{ item -> item.startsWith("a")}.
        forEach {  item -> println(item) }

    println("return: ${returnIntOrNull(1)}")
    println("return: ${if(returnIntOrNull(2)==null) "a" else "b"}")

    // 型チェック
    val xx = 1
    if(xx is Int){
        println("xx is Int")
    }
    val yy = "a"
    if(yy is String){
        println("yy is String")
    }

    val person = Person("kazu", 33)
    println(person)
    println(person.name)
    println(person.age)

    // person.name = "taka" // set出来ない
    person.age = 30 // setできる
    println(person.age)

    val map = mapOf(1 to "One" )
    println(map[1])
    val imap = mutableMapOf(1 to "One")
    imap[2]="2"
    println(imap)
    val i = 1
    println(imap[i])

    val personData = PersonData("naka")
    println(personData.name)
    personData.printName()

    // 関数リテラル
    val func : (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(func(1,2))
    val func2: (Int) -> Int = { it * it}
    println(func2(9))

}

data class PersonData (val name:String){
    fun printName(){
        println(this.name)
    }
}


// val はreadonly, valはwritable
class Person(val name:String, var age: Int){

}

fun returnIntOrNull(a:Int):Int? {
    if(a % 2 == 0){
        return null
    }
    return a
}

fun maxOf (a: Int, b:Int):Int{
    if(a>b){
        return a
    }
    return b
}

// fun で関数定義
fun sum(a:Int,b:Int):Int {
    return a + b
}

// Unit == void
fun printSum(a:Int,b: Int):Unit {
    println(a+b)
}

// 継承させたいClassにはopenを付ける
open class Shape

// constructorをクラス名の後の()内に定義する
// constructorの後に :Class名　で継承できる
class Rectangle(var height:Double, var length: Double):Shape() {
    var primeter = (height + length) * 2
}

