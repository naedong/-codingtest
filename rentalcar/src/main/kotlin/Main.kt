import kotlin.contracts.contract

fun main(args: Array<String>) {
    var park = arrayOf("SOO","OOO","OOO")
    var routes = arrayOf("E 2","S 2","W 1")
    println(solutions(park, routes).contentToString())
//    println(solution(park, routes).contentToString())
}





// park : 공원의 문자열
// routes : 강아지의 움직임
fun solutions(park : Array<String>, routes : Array<String>) : IntArray {
    val n = park.size // 공원의 세로 길이
    val m = park[0].length // 공원의 가로 길이
    val currStart = findStartPosition(park) // 강아지의 시작점을 아는 위치
    val directions = arrayOf("N", "S", "W", "E") // 이동 좌표

    val dy = intArrayOf(-1, 1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)

    for (route in routes){
        val (dir, dist) = route.split(" ")
        val directionIndex = directions.indexOf(dir)
        val nextRow = currStart[1] + dx[directionIndex] * dist.toInt()
        val nextCol = currStart[0] + dy[directionIndex] * dist.toInt()


        println("currt ${currStart[1]}")
        println("currt ${currStart[0]}")

        var index = 0
        var check = false
        if(park.indexOf("X") != null){
           run {
                park.forEach { it ->
                    if(it.contains("X")){
                        check = true

                        return@run
                    }
                    else {
                        index += 1
                    }
                }
           }
        }

        if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n){
            continue
        }

        if(park[nextCol][nextRow] == 'X'){
            continue
        }

        println("  park.size ${  park.size}")
        println(" index ${ index}")

        if(index != park.size){
            if(park[index][nextRow] == 'X'){
                continue
            }
        }


        currStart[0] = nextCol
        currStart[1] = nextRow

    }


    return currStart
}

fun findStartPosition(park: Array<String>): IntArray {
    for( i in park.indices){
        for( j in park[i].indices){
            if(park[i][j] == 'S'){
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(-1, -1)
}

fun solution(park: List<String>, routes: List<String>): List<Int> {
    // park를 문자열로 치환하고 S의 index검색
    val start = park.joinToString("").indexOf('S')
    // park 요소의 길이
    val len = park[0].length
    // 이동을 시작할 위치 [ Y 축 , X 축 ]
    var pos = listOf(start / len, start % len)
    // park의 마지막 요소(Y축)의 마지막 위치(Y축)은 [-1,-1]로 리턴
    if (pos[0] == park.size && pos[1] == len) return listOf(-1, -1)

    routes.forEach { v ->
        // [방향, 거리]
        val arr = v.split(" ").toMutableList()
        // 이동할 방향이 수직인지 확인
        val vtc = arr[0] == "N" || arr[0] == "S"
        // 방향이 위쪽(N)이나 왼쪽(W)인지 확인
        val dir = if (arr[0] == "N" || arr[0] == "W") -1 else 1
        // 방향이 왼쪽과 위쪽이라면 거리를 음수로 변경해 반복문이 끝나면 pos에 더할 값으로 변경
        arr[1] = if (arr[0] == "N" || arr[0] == "W") (-arr[1].toInt()).toString() else arr[1]
        // 이동할 거리만큼 반복
        for (a in 1..Math.abs(arr[1].toInt())) {
            // 이동할 방향이 수직이라면 한칸 이동한 X축 = park[현제 위치 + 한칸이동 * 방향이 N,W 라면 -1 아니라면 1]
            // 수직이 아니라면 현제 있는 X축 = park[pos[0]]
            val check = if (vtc) park[pos[0] + a * dir] else park[pos[0]]
            if (check.isNullOrEmpty() || check[pos[1]] == 'X') return@forEach

            if ((vtc && check[pos[1]] != null) || (!vtc && (check.getOrNull(pos[1] + a * dir) == null || check[pos[1] + a * dir] == 'X'))) {
                return@forEach
            }
        }

        if (vtc) pos = pos.toMutableList().apply { set(0, pos[0] + arr[1].toInt()) }
        else pos = pos.toMutableList().apply { set(1, pos[1] + arr[1].toInt()) }
    }
    return pos
}
