package org.scalarules.dsl.nl

import org.scalarules.dsl.nl.datum.DatumImplicits
import org.scalarules.dsl.nl.grammar._
import org.scalarules.dsl.nl.grammar.meta.DslMacros
import org.scalarules.engine._

import scala.language.experimental.macros

/**
  * Aggregates the keywords and implicit definitions of the Scala-Rules DSL. The implicits available in this
  * trait can be used by importing the `grammar` package object's members, or extending this trait.
  */
trait ScalaRulesDsl extends AfrondingsWordsTrait
  with DslConditionImplicits
  with DslEvaluationImplicits
  with DatumImplicits
  with DslListFilterWord
{

  type ConditionFunction = (Condition, Condition) => Condition

  // Entrypoint for the DSL
  def Gegeven(condition: DslCondition): GegevenWord = macro DslMacros.captureGegevenSourcePositionMacroImpl //scalastyle:ignore method.name

  val resultaten = new ResultatenWord

  val Invoer = new InvoerWord
  val Uitvoer = new UitvoerWord
}

