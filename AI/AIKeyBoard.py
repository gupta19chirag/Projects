import cv2
from cvzone.HandTrackingModule import HandDetector
from time import sleep
from pynput.keyboard import Controller

cap = cv2.VideoCapture(0) # id here is 0
cap.set(3, 1280) # for width
cap.set(4, 720) # for height

detector = HandDetector(detectionCon=0.8)
keys=[["Q","W","E","R","T","Y","U","I","O","P"],
      ["A","S","D","F","G","H","J","K","L",":"],
      ["Z","X","C","V","B","N","M",",",".","/"]
      ]
finalText = ""
keyboard = Controller()
def drawAll(img,buttonList):
    for button in buttonList:
        x, y = button.pos
        w, h = button.size
        cv2.rectangle(img, button.pos, (x + h, y + w), (255, 0, 255), cv2.FILLED)  # cv2.filled is the thickness
        cv2.putText(img, button.text, (x + 15, y + 50), cv2.FONT_HERSHEY_PLAIN, 3, (255, 255, 255), 3)
    return img

class Button:
    def __init__(self,pos,text,size=[65,65]):
        self.pos = pos
        self.text = text
        self.size = size
# We have created a draw method just because we the init method initialization needs to be done for only once.
    # But image needs to be created at every iterations:-

buttonList = []
for j in range(len(keys)):
    for i, key in enumerate(keys[j]):
        buttonList.append(Button([100 * i + 50, 100 * j + 50], key))

while True:
    success, img = cap.read()
    img = detector.findHands(img)
    lmList, bboxInfo = detector.findPosition(img)
    img = drawAll(img, buttonList)
    if lmList:
        for button in buttonList:
            x, y = button.pos
            w, h = button.size
            #lmLiis[8][0] here specifies the tip of the first finger that points on key
            if x < lmList[8][0] < x + w and y < lmList[8][1] < y + h:
                cv2.rectangle(img, button.pos, (x + h, y + w), (175, 0, 175), cv2.FILLED)  # cv2.filled is the thickness
                cv2.putText(img, button.text, (x + 15, y + 50), cv2.FONT_HERSHEY_PLAIN, 3, (255, 255, 255), 3)
                # below is used to find the distance between the first and the middle finger tto identify thhat its a click or not
                l, _ , _ = detector.findDistance(8,12,img,)
                print(l)
                #l is less than 30 means both fingers are close to each other thus consider it as a click
                if l < 30:
                    # Simulation
                    keyboard.press(button.text)
                    cv2.rectangle(img, button.pos, (x + h, y + w), (0,255,0), cv2.FILLED)
                    cv2.putText(img, button.text, (x + 15, y + 50), cv2.FONT_HERSHEY_PLAIN, 3, (255, 255, 255), 3)
                    finalText += button.text
                    sleep(0.15)

    cv2.rectangle(img, (50,350), (700,450), (175, 0, 175), cv2.FILLED)
    cv2.putText(img, finalText, (60,430), cv2.FONT_HERSHEY_PLAIN, 5, (255, 255, 255), 5)

    cv2.imshow("Image", img)
    cv2.waitKey(1) #1 millisecond delay



