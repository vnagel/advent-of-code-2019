package days

import java.lang.Exception
import java.lang.Math.abs
import java.lang.Math.min

class Day03(inputString: String) : Day(inputString) {

    override fun getPartOneSolution(): Any {
        val wirePaths: List<List<Point>> = inputList.map(::createWirePath)
        val wirePathsNoOrigin = wirePaths.map{it.drop(1)}
        val intersections = getIntersections(wirePathsNoOrigin)
        val distancesToOrigin = intersections.map {it.distanceTo(Point.origin)}
        val minDistanceToOrigin = distancesToOrigin.min()
        return minDistanceToOrigin ?: throw Exception("No min distance to origin")
    }

    override fun getPartTwoSolution(): Any {
        return ""
    }

    data class Point(val x: Int, val y: Int) {
        companion object {
            val origin = Point(0,0)
        }
        // Returns list of points in interval (currentLocation, currentLocation + direction * magnitude]
        fun getMovementPath(direction: Char, magnitude: Int) : List<Point>{
            when(direction){
                'U' -> return (1..magnitude).map{Point(x, y + it)}
                'D' -> return (1..magnitude).map{Point(x, y - it)}
                'R' -> return (1..magnitude).map{Point(x + it, y)}
                'L' -> return (1..magnitude).map{Point(x - it, y)}
                else -> throw Exception("Unknown direction")
            }
        }
        fun distanceTo(other: Point): Int{
            return abs(x - other.x) + abs(y - other.y)
        }
    }

    fun createWirePath(inputPath:String) : List<Point> {
        val wirePath: MutableList<Point> = arrayListOf(Point.origin)
        for(move in inputPath.split(",")){
            val direction = move[0]
            val magnitude = move.substring(1).toInt()
            val movementPath = wirePath.last().getMovementPath(direction, magnitude)
            wirePath.addAll(movementPath)
        }
        return wirePath
    }

    fun getIntersections(wirePaths: List<List<Point>>) : List<Point>{
        val firstPathSet = wirePaths[0].toSet()
        val intersections: MutableList<Point> = ArrayList()
        for(index in 1 until wirePaths.size){
            val currentIntersections = wirePaths[index].filter { firstPathSet.contains(it) }
            intersections.addAll(currentIntersections)
        }
        return intersections
    }
}
