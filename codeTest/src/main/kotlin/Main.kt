fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var arr = arrayOf("123","456","789")

    solution(arr)
    println(solution(arr))

    println(testSolution(arr))
}

fun solution(phone_book: Array<String>): Boolean {
    // 전화번호를 사전순으로 정렬
    phone_book.sort()
    for (i in 0 until phone_book.size - 1) {
        // 현재 번호와 다음 번호가 접두사 관계인지 비교
        if (phone_book[i+1].startsWith(phone_book[i])) {
            return false
        }
    }
    return true
}

fun testSolution(book : Array<String>) : Boolean{
     var map = HashMap<String, Int>()
    for (b in book){
        map.put(b, 0)
    }
    for (i in 0 until book.size) {
        for (j in 0 until book.get(i).length) {
            if (map.containsKey(book.get(i).substring(0, j))) return false
        }
    }


    return true
}





