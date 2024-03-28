import turtle
import time

# Function to draw a smooth heart shape
def draw_smooth_heart():
    turtle.color('red')
    turtle.begin_fill()
    turtle.fillcolor('red')
    turtle.left(140)
    for i in range(200):
        turtle.forward(1)
        turtle.right(1)
    turtle.left(120)
    for i in range(200):
        turtle.forward(1)
        turtle.right(1)
    turtle.forward(120)
    turtle.end_fill()

# Function to write "Happy New Year"
def write_happy_new_year():
    turtle.penup()
    turtle.goto(-60, -150)  # Adjusted position for proper alignment
    turtle.color('black')
    turtle.pendown()
    turtle.write("Happy New Year", font=("Arial", 20, "bold"))

# Slowly display the drawings
def slow_display():
    turtle.bgcolor('#e6f7ff')  # Gradient background color
    turtle.speed(10)
    turtle.hideturtle()
    draw_smooth_heart()
    time.sleep(1)  # Pause for a moment before displaying the text
    write_happy_new_year()
    turtle.done()

# Call the slow_display function
slow_display()