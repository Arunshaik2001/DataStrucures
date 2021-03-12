import java.lang.StringBuilder

var a:Int=3 ///static fields


fun main() {
    //mutable variables

    var i:Int
    i=34
    i=10
    val g=22_00_000.0_0F

    //immutable variables
    g.plus(3.3)
    val j:Int
    j=12

    print("enter $i ${j::class.simpleName}")
    println("data type ${i::class.simpleName}")

    i++;
    println(i)

    ///Strings

    var persona:Int?=1;
    persona?.let {
        println(it)
    }

    var strings:String="adadad"
    strings=strings+"sd";
    print(strings.toByteArray().toString())
    for(v:Char in strings) print(v+" ");

    for( i in 0 until  strings.length) print(strings[i]+" ")

    val index:Int=strings.indexOf("d")
    val substr:String =strings.substring(index)
    print(substr)
    var key=if(i==1){
        "ada"
    }else if(i==4){
        "aadadad"
    }
    else{
        "asdada"
    }

    val stringB:StringBuilder = StringBuilder("Aadad")

    stringB.append("ad")

    print(stringB.toString())


    when(key){
        "adada"->{
            print("adadada")
        }
        "adadaa"->{
            println("risedThe")
        }
        else -> println("a")

    }

    var age=12
    when(age){
        in 0..18 , in 45..90->{

        }
        in 19..50->{

        }



    }

    val colorsArray= arrayOf("red","yellow","blue")
    for(i in 0 until colorsArray.size step 2){
        println(colorsArray[i])
    }
    for(i in 10 downTo  0 step 2){
        println(colorsArray[i])
    }

    for(i in (colorsArray.indices).step (2)){
        println(colorsArray[i])
    }

    do{
        println("dada")
    }while (i in 0..12)

    val intArray:IntArray= intArrayOf(2,23,4)
    hello(3,*intArray)

    val (name)=Person1(1)

}

fun hello(r:Int=23,vararg t:Int){
    println(r)
}


open class Person(var name:String,var age:Int){

    fun talk(){
        println("talking")
    }

    fun walk(){
        println("walking")
    }

    open fun sleep(){
        println("sleeping")
    }


}

class Teacher(var name1:String,age:Int):Person(name1,age){
    init {
        name1="dada"
    }

    fun teachMath(){
        super.talk()
        println("arun shaik is teaching")
    }

    override fun sleep(){
        println("teacher sleeping")
    }

}

data class Person1(var a:Int)

interface Animal{
    val ff:Int
    fun speak()
}

class Dog:Animal{
    override val ff: Int=8
        
        get() = field
    override fun speak() {

    }
}



var output=operation(4,5) { a, b->

    a+b

}

fun operation(a:Int,b:Int , operate:(Int,Int)->Int):Int{

    return operate(a,b)
}

