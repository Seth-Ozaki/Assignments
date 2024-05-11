import { model, Schema } from "mongoose";

const BookSchema = new Schema(
    {
        title: {
            type: String,
            required: [true, "The book must have a title!"],
            minlength: [2, "A books title must have than 2 letters!"],
            maxlength: [20, "Whoa there buddy save it for the book!"]
        },
        author: {
            type: String,
            required: [true, "Well Somebody wrote it"],
            minlength: [5, "OK but whats their full name?"],
            maxlength: [50, "That name wont fit on the cover!"]
        },
        pages: {
            type: Number,
            required: [true, "Books have pages!"],
            minlength: [1, "What book do you know with ONE page?"]
        },
        isAvailable: {
            type: Boolean,
            default: false
        }
    },
    { timestamps: true }
);
const Book = model("Book", BookSchema);
export default Book;