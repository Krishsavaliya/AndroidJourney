package dl.thismatters.practiceprojectfun

data class CounterModel(var count : Int)

class CounterRepository{
    private var _counter = CounterModel(0)

    fun getCounetr() = _counter

    fun incrementCounter(){
        _counter.count++
    }
    fun decrementCounter(){
        _counter.count--
    }
}