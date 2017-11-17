/*
 * Copyright (c) 2015 Daniel Higuero.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.scala.exercises

object Exercise1 {
  def main(args: Array[String]) : Unit = {
    val l = List(1, 2, 3, 4, 5)
    val obj = new Exercise1
    val r1 = obj.processList[Int, Int](l, obj.square)
    val r2 = obj.processList[Int, String](l, obj.transformToString)
    val r3 = obj.processList2[Int, Int](l, obj.square)
    val r4 = obj.processList2[Int, String](l, obj.transformToString)
    val r5 = obj.processListMaikMongo[Int, Int](l, obj.square)
    val r6 = obj.processListMaikMongo[Int, String](l, obj.transformToString)
    println(r1)
    println(r2)
    println(r3)
    println(r4)
    println(r5)
    println(r6)
  }
}

/**
 * Class that provides the implementation for the solution of the exercise 1.
 */
class Exercise1 {

  def transformToString(x: Int): String = {x.toString}

  def square(x:Int): Int = {x * x}

  def processList[A, B](l: List[A], op: A => B) ={
      l.foldLeft(Map.empty[A, B])((acc ,cur) => {acc + (cur -> op(cur))})
    }

  def processList2[A, B](l: List[A], op: A => B): Map[A, B] ={
    var map : Map[A, B]= Map.empty
    for (x <- l){
      map += (x -> op(x))
    }
    map
  }

  def processListMaikMongo[A, B](l: List[A], op: A => B): Map[A, B] ={
    var map : Map[A, B]= Map.empty
    l.foreach(x => map += (x -> op(x)))
    map
  }
  }

