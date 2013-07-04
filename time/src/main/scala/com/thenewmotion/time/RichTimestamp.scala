package com.thenewmotion.time

import java.sql.Timestamp
import org.joda.time.DateTime

/**
 * @author Yaroslav Klymko
 */
class RichTimestamp(val self: Timestamp) extends AnyVal {
  def toDateTime: DateTime = new DateTime(self)
}