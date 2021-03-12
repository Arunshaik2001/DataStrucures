import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    var t = scanner.nextInt()
    while (t-- > 0) {
        val n = scanner.nextInt()
        var k = scanner.nextInt()
        val binString = scanner.next().toMutableList()
        var i = 0
        var j = 0
        while (k > 0 && i < n) {
            if (binString[i] == '0') {
                if(i==j){
                    i++
                    j++
                    continue
                }
                if (k >= i) {
                    binString[j++] = '0'
                    binString[i] = '1'
                    k -=i
                } else {
                    if(binString[i-k]!='0'){
                        binString[i - k] = '0'
                        k=1
                    }
                    else{
                        binString[i-k+1]='0'
                        k = 0
                    }
                    binString[i] = '1'

                }

            }
            i++
        }
        println(binString.joinToString(separator = ""))
        

    }
}
