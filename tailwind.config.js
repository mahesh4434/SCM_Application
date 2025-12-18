// tailwind.config.js
// export default {
  // content: ["./**/*.{html,js}"],
  //theme: {
    //extend: {},},
  //plugins: [],
  //darkMode:"selector",
//};

// tailwind.config.js
export default {
  content: [
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/**/*.js"
  ],
  darkMode: "class",   // ✅ FIX HERE
  theme: {
    extend: {},
  },
  plugins: [],
};
