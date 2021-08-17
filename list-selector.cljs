(ns list-selector
  (:require ["ink" :refer [render Text Box useInput]]
            [reagent.core :as r]))



;; TODO: to work as :key later on - assert that :display-name is unique for user-input
(defonce state (r/atom (->> (iterate inc 1)
                         (map (fn [id] {:display-name (str "item " id) :selected false}))
                         (take 5)
                         (map (fn [item] [(:display-name item) item]))
                         (into {}))))

(defn update-selected [state item-key]
  (update-in state [item-key :selected] not))


;; change state to see effects...
(doseq [n (range 1 8)]
  (doseq [[i key] (keep-indexed vector (keys @state))]
    (js/setTimeout #(swap! state (fn [state] (update-selected state key))) (* n i 133))))



(defn list-entry [item-key]
  (let [display-name (get-in @state [item-key :display-name])
        selected (get-in @state [item-key :selected])
        ;;input (useInput (fn input-hook [input, key]
        ;;                  (cond
        ;;                    (.-return key) (swap! @state #(update-selected % item-key)))))
        ]
    [:> Box
     [:> Text "[" (if selected "x" " ") "] " display-name]]))

;; for interop with React-libraries: :> (r/create-class)
(defn app []
  [:> Box {:flexDirection "column" :borderStyle "round" :width 20 :paddingX 1}
   (for [[key item-state] @state]
     ^{:key key} [list-entry key])])



(render (r/as-element [app]))

