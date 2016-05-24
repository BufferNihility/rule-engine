# scala-rules
Scala-Rules is a forward chaining rule engine, built in [Scala](https://www.scala-lang.org). The engine comes with a DSL with which derivations can be modelled as small steps that combine into large derived networks of facts.

The project started with a Dutch DSL to facilitate bankers writing mortgage-related calculations. An English translation of the DSL is still in progress.

[![Codeship Status for scala-rules/scala-rules](https://codeship.com/projects/628dece0-e3e8-0133-a9e8-3aa3f222b1f1/status?branch=master)](https://codeship.com/projects/146192)

# Getting Started

The minimal requirement to get started is to add the artefact containing the rule engine to your project. Below are snippets for SBT and Maven. Be sure to check if any newer versions exist and adjust the snippet accordingly.

**SBT** - `build.sbt`
```
libraryDependencies ++= "org.scala-rules" %% "rule-engine" % "0.2.6"
```

**Maven** - `pom.xml`
```xml
<dependency>
	<groupId>org.scala-rules</groupId>
	<artifactId>rule-engine_2.11</artifactId>
	<version>0.2.6</version>
</dependency>
```

# Concepts

The rule engine uses a `Fact` as the base for all of its derivations. A `Fact` defines its name and type so it can be referenced in evaluations down the road. `Facts` are best defined inside a `Glossary`:

```scala
class MyGlossary extends Glossary {
	val factA = defineFact[Int]("factA")
	val factB = defineFact[Int]("factB")
}
```

*Note: the name of the fact is currently repeated as the first argument of the `defineFact` function. This string is actually used inside the engine and must be unique for all `Facts` used by the engine. We are looking for ways to remove this parameter, if you have any suggestions, let us know.*

Using 

```scala

```




The DSL is currently only available in Dutch. We are working on translating it into English and expect this to be releasable in the next month.

In our project, we are using a utility project to visualise the dependency graphs generated by the engine. These graphs provide great insights in the execution order of the engine and allow for easy review of derivations by non-programmers. This project cannot as of yet be released as an open source module. We are working on generalising this and expect it to be releasable in the next two months. Here’s an example of what a derivation graph looks like:

![Example Dependency Graph showing Execution Order of derivations](./docs/images/example_graph.png)
