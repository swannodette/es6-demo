(require '[clojure.java.io :as io]
         '[cljs.build.api :as b]
         '[clojure.data.json :as json])

(defn node-modules []
  (letfn [(->lib [{:strs [file]}] {:file file :module-type :commonjs})]
    (vec
      (map ->lib
        (json/read-str (slurp (io/file "deps.json")))))))

(println (node-modules))

(b/build (b/inputs "src")
  {:optimizations :advanced
   :main 'es6-demo.core
   :target :nodejs
   :output-to "main.js"
   :output-dir "out"
   :verbose true
   :foreign-libs (into
                   [{:file (.getAbsolutePath (io/file "src/libs/NodeStuff.js"))
                     :provides ["libs.NodeStuff"]
                     :module-type :commonjs}]
                   (butlast (node-modules)))
   :pseudo-names true
   :externs ["process.js"]
   :closure-module-roots []
   :closure-warnings {:non-standard-jsdoc :off}})

(System/exit 0)