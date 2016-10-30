(require '[clojure.java.io :as io]
         '[figwheel-sidecar.repl :as r]
         '[figwheel-sidecar.repl-api :as ra]
         '[cljs.closure :refer [js-transforms]])
(import 'javax.script.ScriptEngineManager)

(defmethod js-transforms :jsx [ijs opts]
  (let [engine (doto (.getEngineByName (ScriptEngineManager.) "nashorn")
                 (.eval (io/reader (io/file "resources/js/jstransform-simple.bundle.js")))
                 (.put "originalCode" (:source ijs)))]
    (merge ijs
      {:source (.eval engine "simple.transform(originalCode, {react: true, es6module: true}).code")})))

(ra/start-figwheel!
  {:figwheel-options
   {:validate-config false
    :css-dirs ["src/resources/public/css"]}
   :build-ids ["dev"]
   :all-builds
   [{:id "dev"
     :figwheel {}
     :source-paths ["src/cljs" "resources/js"]
     :compiler {:main 'es6-demo.core
                :asset-path "/js/out"
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js/out"
                :parallel-build true
                :compiler-stats true
                :verbose true
                :foreign-libs [{:file "resources/js/react.js"
                                :provides ["React"]
                                :module-type :commonjs}
                               {:file "src/js/Components.js"
                                :provides ["Components"]
                                :module-type :es6
                                :preprocess :jsx}]
                :closure-warnings {:non-standard-jsdoc :off}}}]})

(ra/cljs-repl)