fun main(args: Array<String>) {
    val arr = IntArray(5000){ it + 1 }
    val tes = intArrayOf(1, 2, 5)
    val amount = 10000
    val startTime = System.currentTimeMillis()
    val result = editSolution(amount, arr)
    val endTime = System.currentTimeMillis()

    println("Result :${result}")
    println("Time : ${endTime - startTime}")
    println("Program arguments: ${args.joinToString()}")
}

fun solution(amount : Int, coin : IntArray) : Int {
    var answer = 0
    var count = 0
    var test = 0
    var set = amount
    for( c in coin){
        test = set % c
        count += 1

        println(test )
    }
    return 0
}

fun editSolution(amount : Int, coin : IntArray) : Int{
    var answer = IntArray(amount + 1)
    answer[0] = 1

    for (c in coin){
        for(i  in c..amount){
            answer[i] += answer[ i - c]
        }
    }

    return answer[amount]
}
