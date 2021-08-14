(ns list-selector
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]))



(defonce state (r/atom (->> (iterate inc 1)
                         (map (fn [id] {:display-name (str "item " id)}))
                         (take 5))))


(defn hello []
  [:> Box {:flexDirection "column" :borderStyle "round" :width 20 :paddingLeft 1 :paddingRight 1}
   (for [{name :display-name} @state]
     [:> Box {:key name }                                   ;; :borderStyle "round"
      [:> Text "[ ] " name]])])



(render (r/as-element [hello]))

