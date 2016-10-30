(require '[figwheel-sidecar.repl :as r]
         '[figwheel-sidecar.repl-api :as ra])

(defmethod js-transforms :jsx [ijs opts]
  (let [engine (doto (.getEngineByName (ScriptEngineManager.) "nashorn")
                 (.eval (io/reader (io/file "jstransform-simple.bundle.js")))
                 (.put "originalCode" (:source ijs)))]
    (assoc ijs :source
               (.eval engine (str "simple.transform(originalCode, {react: true, es6module: true}).code")))))

(ra/start-figwheel!
  {:figwheel-options {}
   :build-ids ["dev"]
   :all-builds
   [{:id "dev"
     :figwheel {}
     :source-paths ["src/main" "resources/js"]
     :compiler {:main 'es6-demo.core
                :output-to "resources/public/main.js"
                :output-dir "resources/public/out"
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