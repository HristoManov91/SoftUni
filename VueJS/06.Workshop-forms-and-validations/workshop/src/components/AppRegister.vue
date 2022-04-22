<template>
  <div>
    <p class="field field-icon">
      <label for="username"><span><i class="fas fa-user"></i></span></label>
      <input type="text" name="username" id="username" class="error" placeholder="Mark Ulrich">
    </p>
    <div v-if="!$v.formData.fullName">Please enter your name!</div>

    <p class="field field-icon">
      <label for="email"><span><i class="fas fa-envelope"></i></span></label>
      <input type="text" name="email" id="email" placeholder="marg@gmial.com">
    </p>
    <div v-if="!$v.formData.email">Please enter valid email!</div>

    <p class="field field-icon">
      <label for="phone"><span><i class="fas fa-phone"></i></span></label>
      <select name="phoneCode" id="phoneCode" class="tel">
        <option value="1">+359</option>
      </select>
      <input type="text" name="phone" id="phone" placeholder="888 888">
    </p>

    <p class="field field-icon">
      <label for="building"><span><i class="fas fa-building"></i></span></label>
      <select v-model="formData.profession" name="building" id="building" class="building">
        <option v-for="prof in professions" :key="prof" :value="prof">{{prof}}</option>
      </select>
    </p>
    <div v-if="!$v.formData.profession">Please enter your name!</div>

    <p class="field field-icon">
      <label for="password"><span><i class="fas fa-lock"></i></span></label>
      <input type="password" name="password" id="password" placeholder="******">
    </p>
    <div v-if="!$v.formData.password">Please enter your name!</div>

    <p class="field field-icon">
      <label for="re-password"><span><i class="fas fa-lock"></i></span></label>
      <input type="re-password" name="re-password" id="re-password" placeholder="******">
    </p>
    <div v-if="!$v.formData.rePassword">Please enter your name!</div>

    <p>
      <button>Create Account</button>
    </p>

    <p class="text-center">
      Have an account?
      <a href="">Log In</a>
    </p>

  </div>
</template>

<script>

const validateFullName = (text) => {
  const fullNameRegex = '^[A-Z][a-z]+ [A-Z][a-z]+$';
  const result = fullNameRegex.test(text);
  alert(result);
}
const validatePhone = (phone) => {
  const phoneRegex = '^[\\d]{9}$';
  const result = phoneRegex.test(phone);
  return result;
}

const professions = ['Designer', 'Software Engineer', 'Accountant', 'Manager', 'Other'];
import { required, alpha, email , sameAs , between , alphaNum} from 'vuelidate/lib/validators'

export default {
  name: "AppRegister",
  data() {
    return {
      professions: professions,
      formData: {
        fullName: "",
        email: "",
        phone: "",
        profession: "",
        password: "",
        rePassword: "",
      }
    }
  },
  validations: {
    formData: {
      fullName: {
        alpha,
        validateFullName
      },
      email: {
        required,
        email
      },
      phone:{
        required,
        validatePhone
      },
      profession: {
        required,
      },
      password: {
        required,
        alphaNum,
        between: between(3 , 16)
      },
      rePassword: {
        required,
        sameAs: sameAs('formData.password'),
      }
    }
  },
}
</script>

<style>

</style>