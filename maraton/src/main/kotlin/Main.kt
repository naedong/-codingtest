val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()


fun main(args: Array<String>) = with(System.out.bufferedWriter()) {

    println(solutionNet())

    close()
}


fun solutionNet() = with(System.out.bufferedWriter()) {
    val n = getInt() // 풍선의 개수
    val balloons = ArrayList<Pair<Int,Int>>()  // 풍선 리스트
    getIntList().forEachIndexed { idx, i ->
        balloons.add(Pair(i,idx+1))
    }  // 풍선의 리스트 담기
    var idx = 0 //
    while(true){
        write("${balloons[idx].second} ") // 풍선 적기
        var move = balloons[idx].first // 움직이는 것
        balloons.removeAt(idx)
        if(balloons.isEmpty()) break
        if(move>0) move--
        idx += move
        while(idx !in balloons.indices){
            if(idx<0){
                idx+=balloons.size
            }
            idx%=balloons.size
        }
    }
    close()
}

fun solutionGPT()  {
        val n = readLine()!!.toInt() // 풍선 개수 입력 받기
        val balloons = readLine()!!.split(" ").map { it.toInt() }.toMutableList() // 풍선 리스트 입력 받기

        val popped = mutableListOf<Int>() // 터진 풍선을 저장할 리스트
        var current = 0 // 현재 위치
        while (popped.size < n) { // 모든 풍선이 터질 때까지 반복
            popped.add(current + 1) // 현재 위치에 있는 풍선을 터뜨리기
            val move = balloons[current] // 이동할 거리
            balloons[current] = 0 // 풍선에 적힌 수를 0으로 바꾸어 이미 터진 풍선임을 표시
            current += move // 다음 위치 계산
            while (current < 0) { // 왼쪽 끝을 벗어나면 오른쪽 끝으로 이동
                current += n
            }
            current %= n // 오른쪽 끝을 벗어나면 왼쪽 끝으로 이동
            if (balloons[current] == 0) { // 이미 터진 풍선인 경우 다음 위치 계산
                current += move
                while (current < 0) {
                    current += n
                }
                current %= n
            }
        }
        println(popped.joinToString(" ")) // 터진 풍선의 순서 출력

}

fun editGTPSolution() {
        val n = readLine()!!.toInt() // 풍선 개수 입력 받기
        val balloons = readLine()!!.split(" ").map { it.toInt() } // 풍선 리스트 입력 받기

        val popped = mutableListOf<Int>() // 터진 풍선을 저장할 리스트
        val poppedFlags = BooleanArray(n) // 해당 위치의 풍선이 이미 터졌는지 여부를 저장할 배열
        var current = 0 // 현재 위치
        for (i in 0 until n) { // 모든 풍선을 터뜨릴 때까지 반복
            popped.add(current + 1) // 현재 위치에 있는 풍선을 터뜨리기
            poppedFlags[current] = true // 현재 위치의 풍선을 이미 터졌음으로 표시
            val move = balloons[current] // 이동할 거리
            current += move // 다음 위치 계산
            current %= n // 오른쪽 끝을 벗어나면 왼쪽 끝으로 이동
            if (current < 0) {
                current += n
            }
            if (poppedFlags[current]) { // 이미 터진 풍선인 경우 다음 위치 계산
                break
            }
        }
        println(popped.joinToString(" ")) // 터진 풍선의 순서 출력
}