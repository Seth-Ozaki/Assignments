import { model, Schema } from 'mongoose';

const CakeSchema = new Schema(
    {
        name: {
            type: String,
            required: [true, "Please give your cake a name!"],
            minlength: [3, "please use at least 3 chars for {PATH}"],
            maxlength: [22, "please use at most 10 chars for {PATH}"],
        },

        imgUrl: {
            type: String,
            required: [true, "you need an image please!"],
        },

        layers: {
            type: Number,
            default: 2,
            max: [4, "you can't reach the sky!"]
        },

        hasFrosting: {
            type: Boolean,
            default: false
        }
    },
    { timestamps: true }
);
const Cake = model("Cake", CakeSchema);
export default Cake;