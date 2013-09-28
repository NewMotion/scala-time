package com.thenewmotion.time

import scalaz._
import com.thenewmotion.time.factory.{StaticPeriod, StaticDuration}
import com.thenewmotion.time.extension.RichPeriod

object typeinstance extends Instances

@deprecated("Use com.thenewmotion.time.typeinstance._ instead", "3.0")
object ScalazImports extends Instances

trait Instances {
  implicit val durationInstance = new Monoid[Duration] {
    override def zero = StaticDuration.∅
    override def append(f1: Duration, f2: ⇒ Duration) = f1.withDurationAdded(f2, 1)
  }
  implicit val periodInstance = new Monoid[Period] {
    override def zero = StaticPeriod.∅
    override def append(f1: Period, f2: ⇒ Period) = new RichPeriod(f1) + f2
  }
}
