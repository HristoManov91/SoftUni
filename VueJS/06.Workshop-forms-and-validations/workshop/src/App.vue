<template>
  <div id="app">
    <div class="container">
      <form action="" method="post" @submit.prevent="onCreate">
        <fieldset>
          <h1>Registration Form</h1>
          <!--          <AppRegister />-->
          <p class="field field-icon">
            <label for="username"><span><i class="fas fa-user"></i></span></label>
            <input v-model="$v.formData.fullName.$model" type="text" name="username" id="username" class="error" placeholder="Mark Ulrich">
          </p>
          <p class="error" v-if="!$v.formData.fullName.required">Full name is required!</p>
          <p class="error" v-if="!$v.formData.fullName.validateFullName">Full name needs to be like this: Ivan Ivanov!</p>

          <p class="field field-icon">
            <label for="email"><span><i class="fas fa-envelope"></i></span></label>
            <input v-model="$v.formData.email.$model" type="text" name="email" id="email" placeholder="marg@gmial.com">
          </p>
          <p class="error" v-if="!$v.formData.email.required">Email is require!</p>
          <p class="error" v-if="!$v.formData.email.email">Please enter valid email!</p>

          <p class="field field-icon">
            <label for="phone"><span><i class="fas fa-phone"></i></span></label>
            <select name="phoneCode" id="phoneCode" class="tel">
              <option value="1">+359</option>
            </select>
            <input v-model="$v.formData.phone.$model" type="text" name="phone" id="phone" placeholder="888 888">
          </p>
          <p class="error" v-if="!$v.formData.phone.required">Phone is required!</p>
          <p class="error" v-if="!$v.formData.phone.validatePhone">Phone need to be 9 digits!</p>

          <p class="field field-icon">
            <label for="building"><span><i class="fas fa-building"></i></span></label>
            <select v-model="$v.formData.profession.$model" name="building" id="building" class="building">
              <option v-for="prof in professions" :key="prof" :value="prof">{{ prof }}</option>
            </select>
          </p>
          <p class="error" v-if="!$v.formData.profession.required">Please select profession!</p>

          <p class="field field-icon">
            <label for="password"><span><i class="fas fa-lock"></i></span></label>
            <input v-model="$v.formData.password.$model" type="password" name="password" id="password" placeholder="******">
          </p>
          <p class="error" v-if="!$v.formData.password.required">Password is required!</p>
          <p class="error" v-if="!$v.formData.password.alphaNum">Password needs contains only letters and digits!</p>
          <p class="error" v-if="!$v.formData.password.minLength || !$v.formData.password.maxLength">Password length should be between 3 and 16 letters and digits only!</p>

          <p class="field field-icon">
            <label for="re-password"><span><i class="fas fa-lock"></i></span></label>
            <input v-model="$v.formData.rePassword.$model" type="password" name="re-password" id="re-password" placeholder="******">
          </p>
          <p class="error" v-if="!$v.formData.rePassword.sameAs">Passwords don't match!</p>
          <p class="error" v-if="!$v.formData.rePassword.required">Confirm password is required!</p>

          <p>
            <button>Create Account</button>
          </p>

          <p class="text-center">
            Have an account?
            <a href="">Log In</a>
          </p>

        </fieldset>
      </form>
    </div>
  </div>
</template>

<script>
// import AppRegister from "@/components/AppRegister";
const validateFullName = (text) => {
  const fullNameRegex = new RegExp('^[A-Z][a-z]+ [A-Z][a-z]+$');
  return fullNameRegex.test(text);
}
const validatePhone = (phone) => {
  const phoneRegex = new RegExp('^[\\d]{9}$');
  return phoneRegex.test(phone);
}

const professions = ['Designer', 'Software Engineer', 'Accountant', 'Manager', 'Other'];
import {alphaNum, email, required, sameAs, minLength, maxLength} from 'vuelidate/lib/validators'

export default {
  name: 'App',
  data() {
    return {
      submitStatus: 'OK',
      professions: professions,
      formData: {
        fullName: "",
        email: "",
        phone: "",
        profession: [],
        password: "",
        rePassword: "",
      }
    }
  },
  validations: {
    formData: {
      fullName: {
        required,
        validateFullName
      },
      email: {
        required,
        email
      },
      phone: {
        required,
        validatePhone
      },
      profession: {
        required,
      },
      password: {
        required,
        alphaNum,
        minLength: minLength(3),
        maxLength: maxLength(16)
      },
      rePassword: {
        required,
        sameAs: sameAs('password'),
      }
    }
  },
  mounted() {
    const fontAwesomeScript = document.createElement('script');
    fontAwesomeScript.setAttribute("src", "https://kit.fontawesome.com/3cd69e2433.js");
    document.head.appendChild(fontAwesomeScript);
  },
  components: {
    // AppRegister: AppRegister
  },
  methods: {
    onCreate() {
    }
  }
}
</script>

<style>
@import url('./assets/css/style.css');
</style>
