
val numList=ArrayList<Int>();
fun main(){
    for(i in 0 until 10000){
        numList.add(i)
    }
    Thread{printList()}.start()
    Thread{printList()}.start()
    printList()
}

fun printList(){
    for (i in 0 until 10000){
        println("${Thread.currentThread().id} thread")
    }

}

