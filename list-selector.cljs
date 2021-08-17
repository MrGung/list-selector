(ns list-selector
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]))



;; TODO: to work as :key later on - assert that :display-name is unique for user-input
(defonce state (r/atom (->> (iterate inc 1)
                         (map (fn [id] {:display-name (str "item " id) :selected true}))
                         (take 5))))

(println @state)

(defn list-entry [item-state]
  (let [!selected (r/atom (:selected item-state))
        ;;input (useInput (fn input-hook [input, key] (cond (.-return key) (swap! !selected not))))
        ]
    [:> Box
     [:> Text "[" (if (@!selected) "x" " ") "] " (:display-name item-state)]]))

(defn app []
  [:> Box {:flexDirection "column" :borderStyle "round" :width 20 :paddingX 1}
   (for [item-state @state]
     ^{:key (:display-name item-state)} [list-entry item-state])])



(render (r/as-element [app]))

