(ns es6-demo.core
  (:require [React]
            [Components]))

(def ColorInput
  (React/createClass
    #js {:render
         (fn []
           (this-as this
             (React/createElement "div" nil
               (React/createElement "input"
                 #js {:type "text"
                      :className "center"
                      :onChange (.. this -props -onChange)}))))}))

(def Container
  (React/createClass
    #js {:getInitialState
         (fn [] #js {:color ""})
         :handleColorChange
         (fn [event]
           (this-as this
             (.setState this #js {:color (.. event -target -value)})))
         :render
         (fn []
           (this-as this
             (React/createElement "div" nil
               (React/createElement ColorInput #js {:onChange (. this -handleColorChange)})
               (React/createElement Components/Circle #js {:color (.. this -state -color)}))))}))

(React/render
  (React/createElement Container)
  (.getElementById js/document "app"))

(comment
  (Components/vec #js [1 2 3])
  )