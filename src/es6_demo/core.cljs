(ns es6-demo.core
  (:require [libs.NodeStuff :as NodeStuff]))

(enable-console-print!)

(println (NodeStuff/foo 1 2))
(.log js/console (NodeStuff/createElement))
(println [1 2 3])