fun main(args: Array<String>) {
    println(editSolution("aaabbaccccabba"))
}

fun solution(s : String) : Int {
    var result = 0
    var cnt1 = 0
    var cnt2 = 0
    var start = ' '

    for (i in 0 until s.length) {
        if (start == ' ') {
            start = s.get(i)
        }
        if (start == s.get(i)) {
            cnt1++
        } else {
            cnt2++
        }
        if (cnt1 == cnt2) {
            result++
            cnt1 = 0
            cnt2 = 0
            start = ' '
        }
    }
    if (start != ' ') {
        result++
    }

    return result
}


fun editSolution(s : String) : Int {
    var answer  = 0
    var arr = intArrayOf(0, 0)
    var check = ' '
    for(n in 0 until s.length)
    {
       if(check == ' ') check = s.get(n)
       if(check == s.get(n)) ++ arr[0]
       else ++ arr[1]
        if(arr[0] == arr[1]){
           check = ' '
           arr = intArrayOf(0, 0)
           ++ answer
        }
    }
    if(check != ' ') ++ answer
    return answer
}

fun finalSolution(s: String): Int {
    var count = 0
    val charArray = s.toCharArray()
    for (i in 0 until charArray.size - 1 step 2) {
        if (charArray[i] != charArray[i + 1]) {
            count++
        }
    }
    return count
}

fun editFinalSolution(s: String): Int {
    var answer = 0
    var count = 0
    var lastChar = ' '
    for (c in s) {
        if (c != lastChar) {
            lastChar = c
            count = 1
        } else {
            count++
            if (count % 2 == 0) {
                answer++
            }
        }
    }
    return answer
}