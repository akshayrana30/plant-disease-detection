# CLIMATE CHANGE AI HACKATHON

Swift, Accurate, Low Latency Mobile-Based Plant Disease Detector which not only identifies the present disease but also might give early detection with correction methods

<img src = "https://raw.githubusercontent.com/akshayrana30/plant-disease-detection/master/pics/banner.png"/>

<iframe width="640" height="360" src="https://www.youtube.com/embed/RjsLm5PCdVQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

Datasets for the challenge
* Train: https://drive.google.com/open?id=1Z-zMWsxSU8jRHp3h6YWCpQZAG79SD6kd
* Test: https://drive.google.com/open?id=10idTg94ohFjhgEH5jdDBtpoCMhX4ShE9 

External Links
* Dev Post: https://devpost.com/software/plant-disease-detection-d9q5np
* Presentation: https://docs.google.com/presentation/d/1ZHtsKjaItOi7OcEZGwdLc8en2duRIlY00j0ke_8tO6o/edit?usp=sharing 

Files
* prediction.json - This is our prediction for the test set given in the challenge above.
* Plant_Disease_Detection - Image Classification.ipynb - Notebook for training and testing the models.
* PlantSaverApp/outputs/apk/debug/app-debug.apk - APK you can directly install and get started.

## Inspiration
In support of Plant Village Project, we aim to help smallholder farmers grow more food. Farmers who don't have the outreach to beat crop diseases usually feel helpless or become ignorant. The result of this is a lower than average yield of crop production. We feel these small losses in crop productions not only has an impact on the lives of these small farmers but also creates an indirect impact on the GDP of a country.

## What it does
The android application developed for the purpose provides the services while keeping in mind the ease for the user to interact with it. The application provides a handy camera integration to allow the farmer to click an image of the crop he wishes to diagnose. This image is processed in the backend using a deep learning model to classify the plant disease. The classification includes a class "background" exclusively to alert the user that the camera frame did not capture the infected area of the plant properly. It can detect any disease on the plant leaves. Further, it gives information about the parent plant and recommendations on how to improve the plant health and along with information of the natural breeding environment of the plant. If there is any confusion left by the AI, then the app also gives information on symptoms of the disease. This is pretty helpful from the farmer's point of view as informations like these help the farmer to catch early disease symptoms, recognize current infections and also guides how these diseases can be cured. What's more to this is that the application is built using tensorflowlite technology to improve memory and time efficiency of the application. With the help of this, the AI processes the image within seconds without affecting the other processes of the device.

## How we built it
### The AI Model
We used convolution networks for image classification of the disease classes. We converted the model and optimized it using the tensorflowlite format to be used on the android application in memory and time-efficient manner. The tensorflowlite converts the large heavy deep learning models to a smaller and mobile hardware supportive format. It also quantizes the parametric learning weights to reduce the model file size. For example, we converted our convolution model file of 2mb to 200kbs without compromising on the performance of the model. All the database for this app is stored locally to avoid the requirement of internet connection for its usage. The user just needs to click the image of his plant and the app helps them out with the rest.

### The Android Application
The android application was developed using the android studio framework. The different phases of the application involve a live camera feed in the beginning. The user clicks an image from the camera feed. The application sends this image for preprocessing from where it is pushed as input to the AI model (The Magic Box). The AI model outputs the class of the plant and disease. We use this to pull out information about this plant and disease from our knowledge base. The application then displays all the relevant information about the prediction for the farmer's help.

## Challenges we ran into
Setting up a real-time environment in the android application.

## Accomplishments that we're proud of
1) Creating an application where there is access to a camera which is practical enough for a normal user's usage. 
2) The time and memory-efficient AI model implementation which would help this application to be used on lower level android applications. 
3) The display of possible symptoms to catch the disease at an early stage which might be predicted with low confidence by the AI model. Sometimes such low confidence predictions which don't have visual support to prove are ignored by users. Pointing out the symptoms would give a strong support to diagnose a hidden disease at an early stage.
4) Information on how to cure the disease detected. Guides the user with a path for action too instead of just identification and detection.

With all these accomplishments

## What we learned
With even simple impactful applications we can improve a lot indirectly.

## What's next for plant-disease-detection
Integrating a chatbot for more advice and interaction with the user. Adding links to e-commerce website so farmers can order pesticides. Adding climate data integration for alternative crop-weather recommendations. Using the crop propagation data and weather change analysis for pointing out how the climate change has agriculture pattern and hence creating an awareness alongside.

## Quick Start
1. Download the apk and install the app. 
2. Start taking images and getting predictions.

<p align="center">
  <img src = "https://raw.githubusercontent.com/akshayrana30/plant-disease-detection/master/pics/screen1.jpg" width="300"/>
  <img src = "https://raw.githubusercontent.com/akshayrana30/plant-disease-detection/master/pics/screen2.jpg" width="300"/>
</p>



## Future Tasks
* Real Time Detection using drones on the green fields
* Integrating climate data for crop yield prediction and recommendations.
* Chatbot for personalised help.
* Ordering fertilizer from ecommerce site.
* Setting reminder for pesticides/watering etc
* Advising on best practices.



