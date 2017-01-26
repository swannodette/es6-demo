(require '[clojure.java.io :as io]
         '[cljs.build.api :as b])

(b/build (b/inputs "src/cljs" "src/js")
  {:main 'es6-demo.core
   :output-to "out/main.js"
   :output-dir "out"
   :verbose true
   :foreign-libs [{:file (.getAbsolutePath (io/file "src/js/NodeStuff.js"))
                   :provides ["NodeStuff"]
                   :module-type :commonjs}
                  {:file (.getAbsolutePath (io/file "node_modules/object-assign/index.js"))
                   :module-type :commonjs}]
   :closure-warnings {:non-standard-jsdoc :off}})
