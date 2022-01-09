import java.util.*

class guess {
}
var targetGuess = ""
var mark = arrayOf(0,0,0,0)
fun genNum(){
    var guessNum = arrayOf(0,0,0,0)
    guessNum[0] = (1..9).random()
    var i = 1
    while (i<4){
        var n = (0..9).random()
        if(n !in guessNum){
            guessNum[i]=n
            i++
        }
    }
    for (n in guessNum)
        targetGuess += n.toString()
    println(targetGuess)
}
fun checkA(num:String):Int{
    var cnt = 0
    mark = arrayOf(0,0,0,0)
    for (i in 0..targetGuess.length-1)
        if(num[i] == targetGuess[i]){
            mark[i]=1
            cnt++
        }
    return cnt
}
fun checkB(num:String):Int{
    var cnt = 0
    for (i in 0..targetGuess.length-1)
        if(mark[i]==0 && num[i] in targetGuess)
            cnt++
    return cnt
}
fun checkInput(g:String):Boolean{
    var flag =IntArray(10)
    for (i in 0..g.length-1){
        if (g[i].isDigit()==false)
            return false
        var n = g[i].digitToInt()
        if(flag[n]==0)
            flag[n]=1
        else
            return false
    }
    return true
}
fun main(args: Array<String>){
    genNum()

    while (true) {
        print("input :")
        var g = readLine()
        if (g == null)
            break
        if(g.length>4 || g.length==0 || checkInput(g)==false) {
            println("input error")
            continue
        }
        if(g.compareTo("quit") == 0)
            break


        var a = checkA(g)
        var b =checkB(g)
        if(a==4) {
            println("you win")
            break
        }
        println("${a}A${b}B")

    }
}