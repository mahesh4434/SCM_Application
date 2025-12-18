How to Include Tailwind CSS and Flowbite in the Project
1. Start the Project and Run Tailwind

To start the project and compile Tailwind CSS, run the following command:

npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch

2. Use Tailwind CSS on Any HTML Page

If you want to use Tailwind CSS on any page, follow the steps below:

a. Run the Tailwind build command:

npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch


b. Include the generated output.css file in your HTML file.

c. If you want to use the Flowbite library on your HTML page:

Include the Flowbite CSS CDN link inside the <head> section.

Include the Flowbite JavaScript CDN link after the main <div> or before the closing </body> tag.