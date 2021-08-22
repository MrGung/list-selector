(ns reagent
  (:require [reagent.core :as r]
            ["react" :as react]
            ["ink" :refer [render Text]]))

(defn example []
  (let [[count set-count] (react/useState 0)]
    (react/useEffect (fn []
                       (let [timer (js/setInterval #(set-count (inc count)) 500)]
                         (fn []
                           (js/clearInterval timer)))))
    [:> Text {:color "green"} "Hello, world! " count]))

(defn root []
  [:f> example])

(render (r/as-element [root]))
