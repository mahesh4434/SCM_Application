------- How to include tailwinf and flowbite into projecr------
1. #To start project run tailwind by using below command  
npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch

2. If you need tailwind on any page the you have to follow below steps
  a. Run Command  ---   npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch
  b. Include output.css into you html 
  c. if you want flow bite libary on you html page :
     Include css int HEAD and JavaScript after Div using cdn Link 